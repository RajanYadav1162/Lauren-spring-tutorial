# Isolation Levels in Spring Transactions

## 5 Different Types of Isolation Levels

1. **DEFAULT**: The isolation level is dependent on the configuration at the database or datasource level. It uses the default isolation level provided by the underlying data source.

2. **READ_UNCOMMITTED**: This isolation level allows transactions to read uncommitted changes made by other transactions. It poses a risk of dirty reads, where a transaction might read data that another transaction has modified but not yet committed.

3. **READ_COMMITTED**: Transactions at this level ensure that dirty reads do not occur. However, it still allows for repeatable reads, where a transaction may see different values for the same record in different parts of the same transaction timeline.

4. **REPEATABLE_READ**: This isolation level prevents both dirty reads and repeatable reads. It ensures that, within the same transaction, a query executed multiple times will consistently return the same result set.

5. **SERIALIZABLE**: The highest isolation level, it ensures complete isolation from other transactions. It prevents dirty reads, repeatable reads, and phantom reads, making it the most robust but potentially less performant option.

## Problems with Different Isolation Levels

### 1. Dirty Reads

- **Issue**: Dirty reads occur when one transaction reads data that another transaction has modified but not yet committed.
- **Example**:
  T1 ----------10--------------20-------------->20
  T2------------------20..................R-->10

- **Explanation**: T1 reads 20 due to READ_UNCOMMITTED, but if T2 rolls back, T1 still sees an incorrect value.

### 2. Repeatable Reads

- **Issue**: Even with READ_COMMITTED, repeatable reads can occur, where a transaction sees different values for the same record in the same transaction.
- **Example**:
  T1.............10..............20................->
  T2...................20..C........................-->

- **Explanation**: T1 consistently reads 20, but within the same timeline, it observes two different values (10 and 20).

### 3. Phantom Read

- **Issue**: REPEATABLE_READ prevents dirty and repeatable reads but may lead to phantom reads, where a transaction may see additional records that were inserted by another transaction.
- **Example**:
- T1..........100.....................120............->
- T2.................20 C.............................->

- **Explanation**: T1 initially reads 100 products, but after T2 commits 20 more products, T1, on a subsequent read, sees the additional 20 products.

### Conclusion

- `READ_UNCOMMITTED`: Allows dirty reads.
- `READ_COMMITTED`: Prevents dirty reads but may have repeatable reads.
- `REPEATABLE_READ`: Prevents dirty and repeatable reads.
- `SERIALIZABLE`: Highest isolation level, preventing all problems but reduces overall performance of application