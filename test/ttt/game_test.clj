(ns ttt.game-test
  (:require [clojure.test :refer :all]
            [ttt.game :refer [play new-board game-state]]))

(def moves-win1
  (map-indexed vector [[2 2] [1 1] [2 1] [0 0] [2 0]]))

(def moves-win2
  (map-indexed vector [[0 2] [2 2] [1 1] [2 1] [0 0] [2 0]]))

(def moves-draw
  (map-indexed vector [[2 2] [1 1] [2 1] [2 0] [0 2] [1 2] [1 0] [0 0] [0 1]]))

(def moves-play
  (map-indexed vector [[2 2] [1 1] [2 1] [2 0] [0 2] [1 2] [1 0] [0 0]]))

(deftest game-states
  (testing "Game states"
    (is (= :win1 (game-state (reduce play (new-board) moves-win1))))
    (is (= :win2 (game-state (reduce play (new-board) moves-win2))))
    (is (= :draw (game-state (reduce play (new-board) moves-draw))))
    (is (= :play (game-state (reduce play (new-board) moves-play))))))