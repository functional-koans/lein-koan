(ns leiningen.koan
  (:refer-clojure :exclude (test))
  (:use [leiningen.core.main :only (abort)]
        [leiningen.help :only (help-for)]
        [leiningen.core.eval :only (eval-in-project)]))

(defn koan-help []
  (help-for "koan"))

(defn trigger-task [project task]
  (eval-in-project project
                   `(do (koan-engine.runner/exec ~task))
                   `(do (require 'koan-engine.runner))))

(defn run
  "Starts the koan auto-runner (this is what most people want)"
  [project]
  (trigger-task project "run"))

(defn test
  "Runs the internal tests for the koans (for koans developers!)"
  [project]
  (trigger-task project "test"))

(defn random
  "Randomly picks a koan to solve (for after you finish the first time)"
  [project]
  (trigger-task project "random"))

(defn koan
  "Koan runner for Clojure projects."
  {:help-arglists '([run test random])
   :subtasks [#'run #'test #'random]}
  ([project] (abort (koan-help)))
  ([project subtask]
     (case subtask
       "help" (abort (koan-help))
       "run"  (run project)
       "test" (test project)
       "random" (random project)
       (abort (str subtask
                   " is not a valid option. Run "
                   "\"lein koan help\" to see your choices.")))))
