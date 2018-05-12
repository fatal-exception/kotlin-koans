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

class DateRange(val startInclusive: MyDate, val endInclusive: MyDate): Iterable<MyDate>{
  operator fun contains(d: MyDate):Boolean = startInclusive <= d && d <= endInclusive

  inner class DateIterator: Iterator<MyDate> {
    private var currentDate: MyDate = startInclusive
    override fun hasNext(): Boolean = currentDate <= endInclusive
    override fun next(): MyDate {
      val nextDate = currentDate
      currentDate = currentDate.nextDay()
      return nextDate
    }
  }

  override fun iterator(): Iterator<MyDate> = DateIterator()

}
