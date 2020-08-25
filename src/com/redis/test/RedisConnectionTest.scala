package com.redis.test

import java.time.Instant

import redis.clients.jedis.{Jedis, Tuple}

object RedisConnectionTest {

  def main(args: Array[String]): Unit = {

    val redis: Jedis = new Jedis("localhost")

    redis.zadd("name", Instant.now().toEpochMilli, "Ab")
    redis.zadd("name", 0, "Z")
    redis.zadd("name", 0, "Ay")
    redis.zadd("name", 0, "C")
    redis.zadd("name", 0, "I")
    redis.zadd("name", 0, "8")
    redis.zadd("name", 1, "2")

    //    println(redis.zrange("name", 0, 10))
    //    println(redis.zremrangeByScore("name", 1,1))

    println(redis.zrange("name", 0, 10))


    println(redis.zrangeByLex("name", "-", "[I"))


    var v: java.util.Set[Tuple] = redis.zrangeByScoreWithScores("name", Long.MaxValue - 1, Long.MaxValue)


    println(redis.zrangeByScoreWithScores("name", Long.MaxValue - 1, Long.MaxValue))


  }

}
