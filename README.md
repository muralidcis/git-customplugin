## How to create a custom git plugin and use it.

## create a folder 
mdkir -p buildsrc/src/main/groovy/com/example


## create a file GreetingTask.groovy and place it inside example folder 

package com.example

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

class GreetingTask extends DefaultTask {
  def greeting = 'Hello world the git ping'

    @TaskAction
    def greet() {
	println greeting
    }
}

## to compile GreetingTask.groovy and to upload it to maven repo let create a build.gradle under the buildsrc folder


apply plugin: 'groovy'
apply plugin: 'maven-publish'

dependencies {
  compile gradleApi()
    compile localGroovy()
}

publishing {
    publications {
	mavenJava(MavenPublication) {
	    groupId 'com.example'
	    artifactId 'greet'
	    version '1.0-SNAPSHOT'
      
	    from components.java
	}
    }
    repositories {
	maven {
	    url 'file://' + new File(System.getProperty('user.home'), '.m2/repository').absolutePath
	}
    }
}


## gradle build and then gradle publish to upload it to maven repto


## lets use the plugin with a build.gradle
## create a folder view and add the build.gradle to it view/build.gradle with the following code.

apply plugin: 'groovy'

defaultTasks 'hi'

buildscript {
    repositories { mavenLocal() }
    dependencies { classpath 'com.example:greet:1.0-SNAPSHOT' }
}


task hello(type: com.example.GreetingTask)

## run gradle hello to view the out put.


    
