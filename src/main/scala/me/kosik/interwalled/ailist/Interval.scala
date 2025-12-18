package me.kosik.interwalled.ailist

case class Interval[T](
  key:    String,
  from:   Long,
  to:     Long,
  value:  T
)