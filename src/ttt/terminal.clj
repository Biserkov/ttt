(ns ttt.terminal)

(defn player
  "Converts 0, 1 and 2 to the usual character representations."
  [n]
  (nth [\space \O \X] n))

(defn pretty-print
  "Accepts a formatter #{player identity}. Returns a function that will pretty-prints a board."
  [formatter]
  (fn [board]
    (doseq [i [0 1 2]]
      (println (mapv formatter (board i))))
    (println)))