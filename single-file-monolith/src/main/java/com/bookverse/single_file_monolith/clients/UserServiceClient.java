package com.bookverse.single_file_monolith.clients;

// Monolitin de User nesnesini bilmesi gerekir (Veri Taşıma Nesnesi - DTO rolünde)
// Bu yüzden User.java sınıfını entities paketinize geri kopyalayın ve import edin!
import com.bookverse.single_file_monolith.entities.User; 
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {
    
    // Bağımlılık Enjeksiyonu ile RestTemplate alır
    private final RestTemplate restTemplate;
    
    // Çağırılacak Mikroservisin adresi
    private final String userServiceUrl = "http://localhost:8081/api/users";

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Bu metod, eski UserRepository'deki findById metodunun yerini alır.
    public User getUserById(int id) {
        // Yeni mikroservise HTTP GET isteği atılır.
        return restTemplate.getForObject(userServiceUrl + "/" + id, User.class);
    }
}