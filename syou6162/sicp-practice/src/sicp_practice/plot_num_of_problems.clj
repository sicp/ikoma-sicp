(ns sicp-practice.plot-num-of-problems
  (:use [clojure.contrib.string :only (split join)]))

;; What is this?
;; みんなが解いた問題数を適当に画像にするスクリプトです
;; いっぱい解いてモチベーションを上げていきましょう!!!

;; How to use
;; git clone git@github.com:sicp/ikoma-sicp.wiki.git
;; ikoma-sicpと上のikoma-sicp.wikiを同じディレクトリにいると仮定
;; cd $SICP_ROOT/syou6162/sicp-practiceした上で、以下のコマンドを走らせると、画像のURLが返ってきます
;; lein trampoline run -m sicp-practice.plot-num-of-problems < ../../../ikoma-sicp.wiki/Assignments.md

(defn -main [& args]
  (let [cnt-map (-> (->> (line-seq (java.io.BufferedReader. *in*))
			 (map (fn [line] (first (rest (re-find #"^\*.*?(\[.*)" line)))))
			 (filter (complement nil?))
			 (map #(split #", " %))
			 (flatten)
			 (map #(second (re-find #"\[(.*?)\]\(.*?\)" %)))
			 (frequencies))
		    (dissoc "keisks-pdf") ; 名前の統一をしたい感じ...
		    (dissoc "yag_ays.suppl."))
	names (str "|" (join "|" (reverse (keys cnt-map))) "|")
	max-result (apply max (vals cnt-map))
	cnt (join "," (map #(* 100.0 (/ % max-result)) (vals cnt-map)))]
    (str "https://chart.googleapis.com/chart?"
	 "chxt=x,y&"
	 "chxr=0,0," max-result ",5&"	; X軸の範囲。5刻みで
	 "cht=bhs&chd=s:cEj8U&chco=50A4FB&chls=2.0&chs=500x200&"
	 "chxl=1:" names
	 "&chd=t:" cnt)))
