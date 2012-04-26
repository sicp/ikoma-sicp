(def n5tree (generate-huffman-tree '((A 1)
                                     (B 2)
                                     (C 4)
                                     (D 8)
                                     (E 16))))
;; (
;;  (
;;   (
;;    (
;;     (leaf A 1) (leaf B 2) (A B) 3)
;;    (leaf C 4) (A B C) 7)
;;   (leaf D 8) (A B C D) 15)
;;  (leaf E 16) (A B C D E) 31)


(def n10tree (generate-huffman-tree '((A 1)
                                      (B 2)
                                      (C 4)
                                      (D 8)
                                      (E 16)
                                      (F 32)
                                      (G 64)
                                      (H 128)
                                      (I 256)
                                      (J 512))))
;; (
;;  (
;;   (
;;    (
;;     (
;;      (
;;       (
;;        (
;;         (
;;          (leaf A 1) (leaf B 2) (A B) 3)
;;         (leaf C 4) (A B C) 7)
;;        (leaf D 8) (A B C D) 15)
;;       (leaf E 16) (A B C D E) 31)
;;      (leaf F 32) (A B C D E F) 63)
;;     (leaf G 64) (A B C D E F G) 127)
;;    (leaf H 128) (A B C D E F G H) 255)
;;   (leaf I 256) (A B C D E F G H I) 511)
;;  (leaf J 512) (A B C D E F G H I J) 1023)

;; 最高頻度の記号を符号化するのに必要なビット数は 1   (上の図のEやJ)
;; 最低頻度の記号を符号化するのに必要なビット数は n-1 (上の図のA)

;; 上のfig.の通り，相対頻度が1,2,4,...2^{n-1}のようなn個のleafを持つHaffman treeは直線状に伸び，
;; 常にright-branchから枝が伸びることはない．
;; 重みの設定上，任意の正の整数nにおいて\sum _ {i}^{n-1}{2^i} < 2^nとなる．

(right-branch n10tree)
;; (leaf J 512)
(left-branch n10tree)
;; (((((((((leaf A 1) (leaf B 2) (A B) 3) (leaf C 4) (A B C) 7) (leaf D 8) (A B C D) 15) (leaf E 16) (A B C D E) 31) (leaf F 32) (A B C D E F) 63) (leaf G 64) (A B C D E F G) 127) (leaf H 128) (A B C D E F G H) 255) (leaf I 256) (A B C D E F G H I) 511)
