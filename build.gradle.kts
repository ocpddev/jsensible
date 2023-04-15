import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.dokka)
    `maven-publish`
    signing
}

group = "dev.ocpd.jsensible"

kotlin {
    jvmToolchain(17)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
    }
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.named<Jar>("javadocJar") {
    from(tasks.named("dokkaJavadoc"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    api(libs.archunit)
    testImplementation(kotlin("test"))
    testImplementation(libs.archunit.junit)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name.set("jsensible")
                description.set("Sensible Java conventions")
                url.set("https://github.com/ocpddev/jsensible")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                scm {
                    url.set("https://github.com/ocpddev/jsensible")
                }
                developers {
                    developer {
                        id.set("sola")
                        name.set("Sola")
                        email.set("sola@ocpd.dev")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            val releaseUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")

            url = if (version.toString().endsWith("-SNAPSHOT")) snapshotUrl else releaseUrl

            credentials {
                username = project.findSecret("ossrh.username", "OSSRH_USERNAME")
                password = project.findSecret("ossrh.password", "OSSRH_PASSWORD")
            }
        }
    }
}

signing {
    val key = findSecret("ocpd.sign.key", "OCPD_SIGN_KEY")
    if (key != null) {
        val keyId = findSecret("ocpd.sign.key.id", "OCPD_SIGN_KEY_ID")
        val passphrase = findSecret("ocpd.sign.passphrase", "OCPD_SIGN_PASSPHRASE") ?: ""
        useInMemoryPgpKeys(keyId, key, passphrase)
    }
    sign(publishing.publications["maven"])
}

fun Project.findSecret(key: String, env: String): String? =
    project.findProperty(key) as? String ?: System.getenv(env)
