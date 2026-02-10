---
sidebar_position: 1
---

# New Entity

Added Bank entity to the logic

```java
@Entity
@Table(name = "bank")
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<CurrencyEntity> currencies = new ArrayList<>();

    public BankEntity() {}

    public BankEntity(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<CurrencyEntity> getCurrencies() { return currencies; }
    public void setCurrencies(List<CurrencyEntity> currencies) { this.currencies = currencies; }

    public void setId(Long id) {this.id = id;}
}
```

Updated Currency Dto - added bank

```java
@Entity
@Table(name = "currency")
public class CurrencyEntity {
    @Id
    private Long id;
    private String type;
    private double rate;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private BankEntity bank;

    public CurrencyEntity() {    }

    public CurrencyEntity(Long id, String type, double rate) {
        this.id = id;
        this.type = type;
        this.rate = rate;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public double getRate() {
        return this.rate;
    }
}
```