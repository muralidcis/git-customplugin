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

