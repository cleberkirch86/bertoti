document.addEventListener('DOMContentLoaded', () => {
    const listaLivros = document.getElementById('livros-list');
    const formularioAdicionarLivro = document.getElementById('add-livro-form');
    const inputNomeLivro = document.getElementById('livro-name');

    async function buscarLivros() {
        const response = await fetch('/livros');
        const livros = await response.json();
        listaLivros.innerHTML = '';
        livros.forEach(livro => {
            const li = document.createElement('li');
            li.className = 'list-group-item d-flex justify-content-between align-items-center';
            li.textContent = livro.nome;

            const botaoExcluir = document.createElement('button');
            botaoExcluir.className = 'btn btn-danger btn-sm';
            botaoExcluir.textContent = 'Excluir';
            botaoExcluir.addEventListener('click', async () => {
                await fetch(`/livros/${livro.id}`, {
                    method: 'DELETE',
                });
                buscarLivros();
            });

            li.appendChild(botaoExcluir);
            listaLivros.appendChild(li);
        });
    }

    formularioAdicionarLivro.addEventListener('submit', async (event) => {
        event.preventDefault();
        const nome = inputNomeLivro.value;
        if (nome) {
            await fetch('/livros', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ nome }),
            });
            inputNomeLivro.value = '';
            buscarLivros();
        }
    });

    buscarLivros();
});
