package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter{ c -> c.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
  fun<T> List<T>.head() = this[0]
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders
      .filter{ order -> order.isDelivered }
      .flatMap{ order -> order.products }
      .sortedBy { product -> product.price }
      .head()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return customers
      .flatMap{ c -> c.orders }
      .flatMap{ o -> o.products }
      .groupingBy{ p -> p }
      .eachCount()
      .getOrDefault(product, 0)
}
