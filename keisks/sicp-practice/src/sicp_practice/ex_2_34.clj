(defn accumulate [op initial sequ]
    (if (empty? sequ)
          initial
          (op (first sequ)
              (accumulate op initial (rest sequ)))))

(accumulate * 1 '(1 2 3 4 5))
;120

(defn horner-eval [x coefficient-sequence]
  (accumulate (fn [this-coeff higher-terms] (+ this-coeff (* x higher-terms))) ;op
              0 ;initial
              coefficient-sequence)) ; sequence

(horner-eval 2 '(1 3 0 5 0 1))
;79
;
; (accumulate (fn [this-coeff higher-terms] (+ this-coeff (* 2 higher-terms))) ;op
;             0 ; initial
;             (1 3 0 5 0 1))) ; sequence

; (op (first sequ)
;     (accumulate op initial (rest sequ)))

; (op 1)
;     (accumulate op 0 (3 0 5 0 1))

; (+ 1 (* 2 (accumulate op 0 (3 0 5 0 1))))
;
; (+ 1 (* 2 (op (first sequ)
;               (accumulate op initial (rest sequ))))) ; corres line 21
;
; (+ 1 (* 2 (op 3
;               (accumulate op 0 (0 5 0 1))))) ;corres line 24

; (+ 1 (* 2 (+ 3 (* 2 (accumulate op 0 (0 5 0 1))))))

; ... ... ...
(+ 1 (* 2 (+ 3 (* 2 (+ 0 (* 2 (+ 5 (* 2 (+ 0 (* 2 (+ 1 (* 2 (+ 0 0)))))))))))))
;79
