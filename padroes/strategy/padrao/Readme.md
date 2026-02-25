# Implementação com Padrão Strategy

Aqui o problema da herança foi resolvido usando o Strategy.

### O que mudou:
- A lógica de verificação de empréstimo foi pra interface `VerificadorEmprestimo`.
- O `Cliente` agora recebe o verificador por composição.
- Não precisa mais de um monte de subclasse de Cliente só pra mudar um comportamento.

### Como rodar:
`mvn compile`
`mvn exec:java`
