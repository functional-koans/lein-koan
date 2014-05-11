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
  "Doc string for run."
  [project]
  (trigger-task project "run"))

(defn test
  "Doc string for test."
  [project]
  (trigger-task project "test"))

(defn random
  "Randomly picks a koan to solve"
  [project]
  (trigger-task project "random"))

(defn koan
  "Koan runner for Clojure projects."
  {:help-arglists '([run test])
   :subtasks [#'run #'test]}
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
