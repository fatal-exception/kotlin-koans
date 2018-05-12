package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
  : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
      return if (year != other.year) year - other.year
      else if (month != other.month) month - other.month
      else dayOfMonth - other.dayOfMonth
    }
    operator fun rangeTo(other: MyDate) = DateRange(this, other)
  }

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val startInclusive: MyDate, val endInclusive: MyDate){
  operator fun contains(d: MyDate):Boolean = startInclusive <= d && d <= endInclusive
}
