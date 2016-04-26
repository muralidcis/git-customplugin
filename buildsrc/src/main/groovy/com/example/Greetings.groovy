package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class Greeting implements Plugin<Project> {
  void apply(Project target) {
      target.task('greet', type: GreetingTask)
        }
	}