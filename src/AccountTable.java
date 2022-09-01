import java.util.HashMap;
import java.util.Map;

public class AccountTable {
    private final AccountGateway accountGateway;
    /**
     * Account ID -> Account
     */
    private Map<String, Account> accounts = new HashMap<>();

    public AccountTable(AccountGateway accountGateway) {

        this.accountGateway = accountGateway;
    }
}


