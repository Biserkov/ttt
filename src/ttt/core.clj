(ns ttt.core
  (:require [ttt.game :refer [game-state play new-board]]
            [ttt.terminal :refer [pretty-print player]]
            [ttt.game-test :refer [moves-win1 moves-win2 moves-draw moves-play]]))

(defn -main []
  (let [board (new-board)
        moves moves-win1]
    (doall (map (pretty-print player) (reductions play board moves)))
    (println (doall (map game-state (reductions play board moves))))))