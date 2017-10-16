(ns potter.core-test
  (:require [clojure.test :refer :all]
            [potter.core :refer :all]))

(defmulti calculate-price (fn [basket] (count basket)))

(defmethod calculate-price 0 [basket] 0)

(defmethod calculate-price 2 [basket] 16)

(deftest checkout-should
  (testing "calculate 0 cost for empty basket"
    (let [empty-basket []]
      (is (= 0 (calculate-price empty-basket)))))

  (testing "calculate the price for two products without discount"
    (let [basket ["title1" "title1"]]
      (is (= 16 (calculate-price basket)))))

  (testing "calculate the price for two products with discount"
    (let [basket ["title1" "title2"]]
      (is (= 15.2 (calculate-price basket)))))
  )
