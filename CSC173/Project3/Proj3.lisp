(write-line "")
(write-line "")
(write-line "CSC 173 PROJECT 3 - Maryfrances & Carolina")
(write-line "")
(write-line "")
(write-line "")



(defun repl1 (a b)
    (write-line a)
    (format t "Result: ~S~%" (funcall b (read)))
    (write-line "Do you want to run again? [1 for Y, any number for N]")
    (if (= (read) 1)
        (repl1 a b)
    )
)

(defun repl2 (a b)
    (write-line a)
    (format t "Result: ~S~%" (funcall b (read) (read)))
    (write-line "Do you want to run again? [1 for Y, any number for N]")
    (if (= (read) 1)
        (repl2 a b)
    )
)

(defun repl3 (a b)
    (write-line a)
    (format t "Result: ~S~%" (funcall b (read) (read) (read)))
    (write-line "Do you want to run again? [1 for Y, any number for N]")
    (if (= (read) 1)
        (repl3 a b)
    )
)



;MATH FUNCTIONS
(defun mysqrt (S x n)
  (if (= n 0)
      x
    (mysqrt S (* 0.5 (+ x (/ S x))) (- n 1))
  )
)

(write-line "MATH FUNCTIONS")
(write-line "")
(write-line "")

(defun abs (n)
  (if (>= n 0) n (/ n -1))
)
(repl1 "Absolute Value => Enter a single number." #'abs)


(defun factorial (x)
  (if (eql x 0)
      1
    (* x (factorial (- x 1))))
 )
(repl1 "Factorial => Enter a single number." #'factorial)


(defun nth-fibo (n)
  (if (<= n 1) n (+ (nth-fibo (-  n 1)) (nth-fibo (- n 2))))
)
(repl1 "Fibonacci Number => Enter a single number." #'nth-fibo)


(defun right-tri (a b c)
  (if (= (* c c)  (+ (* a a) (* b b)))
      (= 0 0) ; true
    (= 0 1) ;false
  )
)
(repl3 "Right Tri => Enter three numbers separated by a single space" #'right-tri)



;;LIST FUNCTIONS
(write-line "")
(write-line "")
(write-line "LIST FUNCTIONS")
(write-line "")
(write-line "")


(defun append (L1 L2)
  (if (null L1)
      L2
    (cons (car L1) (append (cdr L1) L2))
))
(repl2 "List Append => Enter two parenthesized lists seperated by a single space eg (1 a b 2) (c d 3)" #'append)


(defun reverse (L)
  (if (null L)
      nil
    (append (reverse (cdr L)) (list (car L)))
  )
)
(repl1 "List Reverse => Enter a single parenthesized list eg (1 0 1)" #'reverse)


(defun inlist (x L)
  (if (null L)
      -1
   ;else
      (if (eql x (car L)) (= 0 0) (inlist x (cdr L)))
  )
)

(defun indexof (x L)
  (if (eql -1 (inlist x L))
      -1
    (if (eql x (car L))
        (+ 0 0)
      (+ 1 (indexof x (cdr L)))
    )
  )
)
(repl2 "IndexOf => Enter an element, then a parenthesized list eg 12 (11 12 13) - will return '1'" #'indexof)


(defun addtoend (x L)
  (reverse (cons x (reverse L)))
)
(repl2 "Add To End => Enter a number, then a parenthesized list eg 4 (1 2 3)" #'addtoend)




;;SET FUNCTIONS
(write-line "")
(write-line "")
(write-line "SET FUNCTIONS")
(write-line "")
(write-line "")


(defun member (x L)
  (if (null L)
      nil
   ;else
    (if (eql x (car L)) t (member x (cdr L)))
  )
)
(repl2 "Member => Enter a set element, then a parenthesized set eg a (a b c)" #'member)


(defun insert (x L)
    (if (eql x (car L)) 
           L 
        (cons x L)
     )
)
(repl2 "Insert => Enter a set element, then a parenthesized set eg a (a b c)" #'insert)


(defun cardinality (L)
    (if (null L) 
        0
        (+ 1 (cardinality (cdr L)))
    )
)
(repl1 "Cardinality => Enter a valid, parenthesized set (ie no duplicates)" #'cardinality)


(defun inter (L1 L2 L3)

    (if (null L1)
        L3

        ;else
        (if (member (car L1) L2)
            (inter (cdr L1) L2 (insert (car L1) L3))
          (inter (cdr L1) L2 L3)
        );end of else
    )
)

(defun intersection (L1 L2)
    (inter L1 L2 '())
)
(repl2 "Intersection => Enter two parenthesized sets eg (a b c) (d b c) - returns '(b c)'" #'intersection)




;;REQUIRED FUNCTIONS
(write-line "")
(write-line "")
(write-line "REQUIRED FUNCTIONS")
(write-line "")
(write-line "")
(defun mod (a b)

  (if (>= (- a b) b)
      (mod (- a b) b)
    (- a b)
    )
)


(defun sumOfFactors (n i s)

  (if (< i n)
      (if (= (mod n i) 0)   ;condition, if (n%i == 0)
           (sumOfFactors n (+ i 1) (+ s i))   ;action 
         (sumOfFactors n (+ i 1) s)  ;else

       );end of smaller if/action


    ;else return the sum
    s
  );end of if(i < n)

)

(defun perfectp (n)
 (if (= (sumOfFactors n 1 0) n) (= 0 0) (= 0 1))
 )
 (repl1 "Perfect => Enter a single number" #'perfectp)


(defun abundantp (n)
 (if (> (sumOfFactors n 1 0) n) (= 0 0) (= 0 1))
 )
(repl1 "Abundant => Enter a single number" #'abundantp)


(defun deficientp (n)
 (if (< (sumOfFactors n 1 0) n) (= 0 0) (= 0 1))
 )
(repl1 "Deficient => Enter a single number" #'deficientp)



;;BONUS
(write-line "")
(write-line "")
(write-line "BONUS FUNCTIONS")
(write-line "")
(write-line "")


(defun gcd (a b)
    (if (= a 0)
        b
        (gcd (mod b a) a)
    )
)
(repl2 "GCD => Enter two space-separated numbers" #'gcd)


(defun lcm (a b)
    (/ (* a b) (gcd a b))
)
(repl2 "LCM => Enter two space-separated numbers" #'lcm)


(defun primep (a)
    (if (=  1 (sumOfFactors a 1 0))
        t
    )
)
(repl1 "Is Number Prime? => Enter a single numbers" #'primep)


(defun difference (L1 L2)
    (diff L1 L2 '())
)

(defun diff (L1 L2 L3)
    (cond
        ((null L1) L3)
        
        ((eql (member (car L1) L2) 'nil)
             (diff (cdr L1) L2 (cons (car L1) L3))
        )
        
        (t (diff (cdr L1) L2 L3))
    )  
)
(repl2 "Difference => Enter two space-separated lists" #'difference)


(defun symdiff (L1 L2)
    (append (difference L1 L2) (difference L2 L1))
)
(repl2 "Symmetric Difference => Enter two space-separated lists" #'symdiff)


(defun subsetp (L1 L2)
    (cond
        ( (null (difference L1 L2)) t)
        (t nil)
    )
)
(repl2 "Subset => Enter two space-separated lists" #'subsetp)


(defun supersetp (L1 L2)
    (if (subsetp L2 L1)
        t
     )
)
(repl2 "Superset => Enter two space-separated lists" #'supersetp)


(defun nub (L)
  (cond 
      ((null L) L)
        ((member (car L) (cdr L)) (nub (cdr L)))
        (t (cons (car L) (nub (cdr L))))
   )
)


(defun union (L1 L2)
    (nub (append L1 L2))
)
(repl2 "Union of Sets => Enter two sets" #'union)
(repl1 "Remove Duplicates => Enter a list" #'nub)





(write-line "")
(write-line "")
(write-line "Thank you for running our code!")
(write-line "")
(write-line "")
(write-line "")
