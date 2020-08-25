package com.test

object Test {

  def getCities(hotels: List[(String, String, String)]): List[String] = {

    println(hotels.groupBy(_._3))


    var cities: Map[String, Map[String, List[(String, String, String)]]] = Map.empty

    hotels.groupBy(_._3).
      foreach(c => {
        val x = c._2.groupBy(_._2)
        cities = cities ++ Map(c._1 -> x)
      })

    println(cities)

    var cityList: List[String] = List.empty

    cities.foreach(c => {
      c._2.foreach(n => {
        if (n._2.size >= 3) {
          cityList = cityList :+ c._1
        }
      })
    })

    cityList

  }

  def passingCars(a: Array[Int]): Int = {

    var sum: Long = a.sum

    var count: Long = 0;

    a.foreach(e => {
      if (e == 0)
        count = count + sum
      else
        sum = sum - 1
    })

    if (count > 1000000000)
      return -1

    count.toInt

  }

  def missingNumber(a: Array[Int]): Int = {

    var num: Int = 1
    var numbers: Set[Int] = Set.empty

    a.filter(e => e > 0).foreach(e => numbers += e)

    while (numbers.contains(num))
      num = num + 1

    num
  }

  def genomicRangeQuery(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {

    var result: Array[Int] = new Array[Int](p.length)

    for (i <- p.indices) {

      val sub = s.substring(p(i), q(i) + 1)

      if (sub.contains("A"))
        result(i) = 1
      else if (sub.contains("C"))
        result(i) = 2
      else if (sub.contains("G"))
        result(i) = 3
      else if (sub.contains("T"))
        result(i) = 4

    }

    result

  }

  def main(args: Array[String]): Unit = {


    var hotels: List[(String, String, String)] = List(("hotel_1234", "Hilton", "Amsterdam"),
      ("hotel_1000", "Sheraton", "Buenos Aires"),
      ("hotel_1001", "Hilton", "Amsterdam"),
      ("hotel_1002", "Royal Palace", "Bogota"),
      ("hotel_1003", "Hilton", "Amsterdam"),
      ("hotel_1004", "Sheraton", "Buenos Aires"),
      ("hotel_1235", "Sheraton", "Buenos Aires"))


    //    println(getCities(hotels))

    var a: Array[Int] = Array(0, 1, 0, 1, 1)

    //    println(passingCars(a))

    //    println(missingNumber(Array(1, 3, 6, 4, 1, 2)))

    val p = Array(2, 5, 0)
    val q = Array(4, 5, 6)
    val s = "CAGCCTA"

    val r = genomicRangeQuery(s, p, q)

    println("size: " + r.size)

  }

}
