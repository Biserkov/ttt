(ns ttt.game)

(def ^:private empty-row [0 0 0])

(defn new-board
  "Creates an board with 3 empty rows."
  []
  {0 empty-row
   1 empty-row
   2 empty-row})

(defn play
  "Accepts a board and a turn. Returns a new board."
  [board [turn coords]]
  (assoc-in board coords (inc (mod turn 2))))

(defn- winner? [[a b c]]
  (and (= a b c)
       (pos? a)
       a))

(defn unoccupied? [row]
  (some zero? row))

(defn game-state
  "Accepts a board. Returns current games state: :play, :win1, :win2 or :draw."
  [board]
  (if-let [winner (some winner? [(board 0)
                                 (board 1)
                                 (board 2)
                                 (mapv #(get-in board %) [[0 0] [1 0] [2 0]])
                                 (mapv #(get-in board %) [[0 1] [1 1] [2 1]])
                                 (mapv #(get-in board %) [[0 2] [1 2] [2 2]])
                                 (mapv #(get-in board %) [[0 0] [1 1] [2 2]])
                                 (mapv #(get-in board %) [[0 2] [1 1] [2 0]])])]
    (nth [:win1 :win2] (dec winner))
    (if (some unoccupied? (vals board))
      :play
      :draw)))