package Lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class LivrosDemo {

	public static void main(String[] args) {
		SpringApplication.run(LivrosDemo.class, args);
	}
}

@RestController
@RequestMapping("/livros")
class RestApiDemoController {
	private List<Livros> livros = new ArrayList<>();

	public RestApiDemoController() {
		livros.addAll(List.of(
				new Livros("Senhor dos Anéis"),
				new Livros("O Cravo e a Rosa")

		));
	}

	@GetMapping
	Iterable<Livros> getLivros() {
		return livros;
	}

	@GetMapping("/{id}")
	Optional<Livros> getLivrosById(@PathVariable String id) {
		for (Livros c: livros) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	@PostMapping
    Livros postLivros(@RequestBody Livros livros) {
		this.livros.add(livros);
		return livros;
	}

	@PutMapping("/{id}")
	ResponseEntity<Livros> putLivros(@PathVariable String id,
                                     @RequestBody Livros livros) {
		int livrosIndex = -1;

		for (Livros c: this.livros) {
			if (c.getId().equals(id)) {
				livrosIndex = this.livros.indexOf(c);
				this.livros.set(livrosIndex, livros);
			}
		}

		return (livrosIndex == -1) ?
				new ResponseEntity<>(postLivros(livros), HttpStatus.CREATED) :
				new ResponseEntity<>(livros, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteLivros(@PathVariable String id) {
		livros.removeIf(c -> c.getId().equals(id));
	}
}

class Livros {
	private final String id;
	private String name;

	public Livros(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Livros(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}