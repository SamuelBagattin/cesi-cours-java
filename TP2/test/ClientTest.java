import com.cesi.bankonet.Client;
import com.cesi.bankonet.CompteCourant;
import com.cesi.bankonet.CompteEpargne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client clientWithCompteEpargne;
    private Client clientWithoutCompteEpargne;

    @BeforeEach
    public void init(){
        var compteEpargne = new CompteEpargne("EER455", "CompteEpargne1", 50, 1);
        var compteCourant = new CompteCourant("EER456", "CompteCourant1", 50, 1);
        clientWithCompteEpargne = new Client("Client1", "Test", "Test", compteCourant, compteEpargne);
        clientWithoutCompteEpargne = new Client("Client2", "Test", "Test", compteCourant);

    }

    @Test
    public void should_returnRightAmountOfTOtalBalance_ClientWithoutCompteEpargne(){
        assertEquals(50, clientWithoutCompteEpargne.calculerAvoirGlobal());
    }

    @Test
    public void should_returnRightAmountOfTOtalBalance_ClientWithCompteEpargne(){
        assertEquals(100, clientWithCompteEpargne.calculerAvoirGlobal());
    }

    @Test
    public void should_throwExceptionWhenCompteCourantIsNull(){
        assertThrows(NullPointerException.class, () -> new Client("Client2", "Test", "Test", null));
    }
}
