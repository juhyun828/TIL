```java
@Getter
@AllArgsConstructor(staticName = "create")
static class User {
    private Long userId;
}

@Getter
@AllArgsConstructor(staticName = "create")
static class Order {
    private Long userId;
    private Long orderId;
}
```

```java
List<User> userList = Lists.newArrayList(User.create(1L), User.create(2L), User.create(2L));

List<Order> orderList = Lists.newArrayList(Order.create(1L, 1L), Order.create(2L, 2L));
```

## Inner Join
- 주문을 한 사용자
```java
Map<Long, User> userIdMap = userList.stream()
        .collect(Collectors.toMap(User::getUserId, Function.identity()));

List<Pair<Order, User>> innerJoinList = orderList.stream()
    .filter( it -> userIdMap.containKey( it.getUserID ) )
    .map( it -> Pair.of( it, userIdMap.get( it.getUseId ) ) )
    .collect( Collectors.toKist() );
```

## Left Join
- 주문을 하지 않은 사용자
```java
Map<Long, Order> orderIdMap = orderList.stream()
        .collect(Collectors.toMap(Order::getUserId, Function.identity()));

List<User> leftJoinUser = userList.stream()
        .filter( it -> !orderIdMap.containsKey( it.getUserId() ) )
        .collect( Collectors.toList() );
```

[출처](https://helloino.tistory.com/61)