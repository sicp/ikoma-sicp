# 図形言語の肝

## 分からなくなってきたら
入出力の型を意識して、そこにある閉包性を見出すこと。分からなくなったら関数の型を書く!!!

### painterの入出力の型
- input: frameとグラフィックスオブジェクト
- output: (実際にSwingに描く)

### tranform-painterの入出力の型
- input: painter、origin、corner1、corner2
-- painterが重要
- output: (frameとグラフィックスオブジェクトを引数に取るような)painterを返す関数

ここで、`tranform-painter`は入力にもpainter、出力にもpainterとなっている点に注意しよう。[チャーチ数](https://github.com/sicp/ikoma-sicp/blob/master/syou6162/sicp-practice/src/sicp_practice/ex_2_6.clj)のところでも説明したが、入出力の型に閉包性があると、それを次々に適用させていくことができ、その過程で簡単なものを組み合せて複雑な操作を行なうことができる。

今回の図形言語の場合、`flip-vert`や`beside`などが簡単な関数になっており、`tranform-painter`をbaseとしたpainterに閉包性がある、ということが分かると理解が進んでくる。

## wave
`wave`は`segments->painter`に`segment`のリストを投げたものが帰ってきている。

```clojure
(def wave
     (segments->painter
      (list
       (make-segment (make-vect 0.40 1.00)
		     (make-vect 0.35 0.80))
       (make-segment (make-vect 0.65 0.80)
		     (make-vect 0.60 1.00)))))
```

`segments->painter`はsegmentのリストを引数に取って関数を返す関数。どんな関数を返すかといえばフレームとグラフィックスのオブジェクトを引数に取って、外の環境にあるsegmentのリストに対して`draw-line`していく関数。グラフィックスオブジェクトは教科書には出てきていないclojureの都合で入っている引数。

```clojure
(defn segments->painter [segment-list]
  (fn [frame g]
    (doseq [segment segment-list] ;; mapだと遅延評価で何も書かれなくなってしまう。(doall (map...))でもいいけど、doseqで
      ((draw-line
	((frame-coord-map frame) (start-segment segment))
	((frame-coord-map frame) (end-segment segment)))
       frame g))))
```

これだけじゃよく分からんので、実際に使っている関数を見ていくことにしよう(後々見ていくと分かるが、中の(fn [frame g] ...)が結局のpainterになっている)。

## rotate90
実際に回転させたりしている関数(rotate90)を見ると中でpainterに対してtranform-painterを呼んでいる。

```clojure
(defn rotate90 [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))
```

transform-painterではpainterとorigin、corner1、corner2の4つを引数として取っている。戻り値(つまりこれはrotate90とかの戻り値ともなる)は関数。この関数はフレームを引数に取り、painterを返すような関数。中では座標軸の変換をして新しいフレームを作りpainterを呼んでいる。

```clojure
(defn transform-painter [painter origin corner1 corner2]
  (fn [frame g]
    (let [m (frame-coord-map frame)
	  new-origin (m origin)
	  new-frame (make-frame new-origin
				(sub-vect (m corner1) new-origin)
				(sub-vect (m corner2) new-origin))]
      (painter new-frame g))))
```

あとでpainterの定義を調べようと思ったらただのtransform-painterの引数であった。。。実際に使う付近はpolygon-example-1などがある。

```clojure
(defn polygon-example-1 [c g]
  ((square-limit wave 4) my-frame g))
```

中の(fn [frame g] ...)が結局のpainterになっている。

```clojure
(defn segments->painter [segment-list]
  (fn [frame g]
    (doseq [segment segment-list] ;; mapだと遅延評価で何も書かれなくなってしまう。(doall (map...))でもいいけど、doseqで
      ((draw-line
	((frame-coord-map frame) (start-segment segment))
	((frame-coord-map frame) (end-segment segment)))
       frame g))))
```
