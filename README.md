# Spring Transaction Propagation

## Overview
This document provides a comprehensive understanding of Spring transaction propagation levels in a simple application. The project utilizes essential dependencies, including `spring-context`, `spring-jdbc`, `spring-txn`, and `mysql-connector-java`.

## Propagation Levels

1. **REQUIRED**
    - **Example:**
      ```java
      @Transactional(propagation = Propagation.REQUIRED)
      public void methodA() {
         // Transaction created
         methodB();
      }
      ```
    - **Explanation:**
        - Default behavior.
        - Creates a new transaction if none exists; otherwise, uses the existing one.

2. **REQUIRES_NEW**
    - **Example:**
      ```java
      @Transactional(propagation = Propagation.REQUIRED)
      public void addOneProduct(Product products) {
         for(int i = 1; i <= 10; i++) {
            var product = new Product();
            product.setName("product " + i);
            
            // Each addProduct call creates a new transaction.
            productRepository.addProduct(product);
 
            if(i == 5) throw new RuntimeException("Exception to rollback inserted data");
         }
      }
 
      @Transactional(propagation = Propagation.REQUIRES_NEW)
      public void addProduct(Product product) {
         String sql = "INSERT INTO product VALUES(NULL, ?)";
         jdbcTemplate.update(sql, product.getName());
      }
      ```
    - **Explanation:**
        - Creates a new transaction, regardless of the existing one.
        - Changes committed in the nested method won't roll back if an exception occurs.

3. **MANDATORY**
    - **Example:**
      ```java
      @Transactional(propagation = Propagation.MANDATORY)
      public void methodB() {
         // Uses the existing transaction; throws an exception if none exists.
      }
      ```
    - **Explanation:**
        - Requires an existing transaction in the calling environment; otherwise, throws an exception.

4. **NOT_SUPPORTED**
    - **Example:**
      ```java
      @Transactional(propagation = Propagation.NOT_SUPPORTED)
      public void methodA() {
         methodB();
      }
      ```
    - **Explanation:**
        - Executes without a transaction.
        - If method A is transactional, it throws an exception.

5. **NEVER**
    - **Example:**
      ```java
      @Transactional(propagation = Propagation.NEVER)
      public void methodB() {
         // Method should not be called within a transactional context.
      }
      ```
    - **Explanation:**
        - Opposite of MANDATORY; should not be called within a transactional context.

6. **SUPPORTS**
    - Propagates the existing transaction if available; otherwise, executes without a transaction.

7. **NESTED**
    - Rarely used; executes a transaction within another transaction.

## Best Practices and Considerations

- **Atomicity**: Ensure that each transaction is atomic, and changes are committed only if the entire operation is successful.

- **Exception Handling**: Be cautious with exception handling, especially in nested transactions, to avoid unexpected behavior.

- **Transactional Boundaries**: Clearly define transactional boundaries to maintain a consistent state in the database.

- **Rollback Policies**: Understand the implications of rollback policies for different propagation levels.

- **Logging and Monitoring**: Implement logging and monitoring to track transactional behavior and diagnose issues.

In summary:
- **REQUIRED**: Creates a new transaction or uses an existing one.
- **REQUIRES_NEW**: Always creates a new transaction.
- **MANDATORY**: Uses an existing transaction; throws an exception if none exists.
- **NEVER**: Should not be called within a transactional context.
- **NOT_SUPPORTED**: Executes without a transaction.
- **SUPPORTS**: Propagates the existing transaction if available.
- **NESTED**: Executes a transaction within another transaction, but rarely used.
