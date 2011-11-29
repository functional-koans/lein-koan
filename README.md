# lein-koan

lein-koan is a Leiningen plugin for the [Clojure Koan Engine](https://github.com/functional-koans/clojure-koan-engine).

The plugin makes two tasks available:

`lein koan run`:  watches koan files for changes and presents the user with the most advanced unsolved koan.

`lein koan test`: checks that all koans fail without answers and pass with answers.

## Usage

Add the following to your `project.clj` under `:dev-dependencies`:

    [lein-koan "0.1.0"]

To see the plugin in action, try out the [clojure-koans](https://github.com/functional-koans/clojure-koans) with the following commands:

    git clone git@github.com:functional-koans/clojure-koans.git
    cd clojure-koans
    lein deps
    lein koan run

To run the clojure-koans tests, try

    lein koan test

## Writing your own koans 

Lein-koan makes it easy to add koans to existing libraries.

- Write some koans using the instructions at the [koan-engine wiki page](https://github.com/functional-koans/clojure-koan-engine/wiki/How-to-write-koans)
- Add `lein-koan` to your project
- `lein koan run`

and you're off!

For information on how to create your own standalone koan project, check out the instructions at the [koan-template github page](https://github.com/functional-koans/koan-template). The README contains everything you need to know to start writing your own koans and serving them to users.

### License

The use and distribution terms for this software are covered by the
bEclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
which can be found in the file epl-v10.html at the root of this distribution.
By using this software in any fashion, you are agreeing to be bound by
the terms of this license.
