(ns aoc.2021.01
  (:require [aoc.utils :as utils])
  (:gen-class))

(def sample [199
             200
             208
             210
             200
             207
             240
             269
             260
             263])

(count (filter #(< (first %) (second %)) (map vector sample (rest sample))))

(defn get-increases
  "The number of elements whose successor increases"
  [nums]
  (count
    (filter
      #(< (first %) (second %))
      (map vector nums (rest nums)))))

(defn rolling-sums
  "The sum of the first three elements of nums, then the second, third, and
  fourth element of nums, and so on"
  [nums]
  (let [seconds (rest nums)
        thirds (rest seconds)
        sums (map + nums seconds thirds)]
    sums))

(def solve-1 get-increases)

(def solve-2 (comp get-increases rolling-sums))

(utils/get-read-lines 2021 1)

(defn validate [& args]
  (let [input (utils/get-read-lines 2021 1)]
    (do
      (assert (= (solve-1 sample) 7))
      (assert (= (solve-1 input) 1466))
      (assert (= (solve-2 sample) 5))
      (assert (= (solve-2 input) 1491)))))

(defn)