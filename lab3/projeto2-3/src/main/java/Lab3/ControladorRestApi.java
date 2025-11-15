package Lab3;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class ControladorRestApi {
    private final JdbcTemplate jdbcTemplate;

    public ControladorRestApi(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Livro> obterLivros() {
        return jdbcTemplate.query("SELECT * FROM livro", this::mapRowToLivro);
    }

    private Livro mapRowToLivro(ResultSet rs, int rowNum) throws SQLException {
        return new Livro(rs.getString("id"), rs.getString("nome"));
    }

    @GetMapping("/{id}")
    public Optional<Livro> obterLivroPorId(@PathVariable String id) {
        List<Livro> results = jdbcTemplate.query("SELECT * FROM livro WHERE id = ?", this::mapRowToLivro, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @PostMapping
    public Livro publicarLivro(@RequestBody Livro livro) {
        jdbcTemplate.update("INSERT INTO livro (id, nome) VALUES (?, ?)", livro.getId(), livro.getNome());
        return livro;
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable String id, @RequestBody Livro livro) {
        jdbcTemplate.update("UPDATE livro SET nome = ? WHERE id = ?", livro.getNome(), id);
        return livro;
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable String id) {
        jdbcTemplate.update("DELETE FROM livro WHERE id = ?", id);
    }
}
