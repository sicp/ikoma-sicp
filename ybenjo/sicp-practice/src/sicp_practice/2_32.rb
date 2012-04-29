# -*- coding: utf-8 -*-
# clj じゃ説明しにくいので ruby の擬似コードで書く
# スペースが関数の内部に相当する

in_0 = [1, 2, 3]
subsets(in_0)

  # subsets([1, 2, 3]) の中
  in_1 = [2, 3]
  rest_1 = subsets(in_1)

    # subsets([2, 3]) の中
    in_2 = [3]
    rest_2 = subsets(in_2)

      # subsets([3]) の中
      in_3 = [nil]
      rest_3 = subsets(in_3)

      # subsets([nil]) の中
        # return [nil] となるので

      # subsets([3]) に戻ってくる
      rest_3 = [nil]
      concat(rest_3, rest_3.map{ |e| cons(in_2.first, e)})
      # concat(nil, [nil].map{ |e| cons([3].first, e)})
      #=> [nil, [3]]
      # これは subsets(in_2) の返り値

    # subsets([2, 3]) に戻ってくる
    rest_2 = [nil, [3]]
    concat(rest_2, rest_2.map{|e| cons(in_1.first, e)})
    # concat([nil, [3]],
    #        [nil, [3]].map{|e| cons([2, 3].first, e)})
    # #=> [nil, [3], [2], [2, 3]]
    # これは subsets(in_1) の返り値

  # subsets([1, 2, 3]) に戻ってくる
  rest_1 = [nil, [3], [2], [2, 3]]
  concat(rest_1, rest_1.map{|e| cons(in_0.first, e)})
  # concat([nil, [3], [2], [2, 3]],
  #        [nil, [3], [2], [2, 3]].map{|e| cons([1, 2, 3].first, e)})
  # #=> [nil, [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
  # これは subsets([1, 2, 3]) の返り値

# 最後の答え
[nil, [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]


