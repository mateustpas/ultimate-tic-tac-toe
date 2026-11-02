# Ultimate Tic-Tac-Toe (Mega Jogo da Velha)

Implementação das regras completas do Ultimate Tic-Tac-Toe via console/terminal, onde um tabuleiro global 3x3 é composto por nove tabuleiros locais secundários.
O projeto foi desenvolvido para exercitar a modelagem de sistemas estruturados, o controle de matrizes bidimensionais e o fluxo de regras dinâmicas e dependentes de estado.

---

## Objetivos de Aprendizado

- Modelar estruturas de dados compostas e tabuleiros matriciais aninhados.
- Gerenciar estados de jogo interdependentes, onde uma jogada restringe e determina as ações subsequentes.
- Praticar a validação de regras condicionais e tratamento de fluxos de entrada e exceções.

---

## Tecnologias Utilizadas

- Linguagem: Java 
- Paradigma: Lógica de programção
- Interface: Terminal

---

## Mecânicas do Jogo

- Tabuleiro Aninhado: Tabuleiro principal 3x3 dependente dos resultados de 9 tabuleiros menores internos.
- Encadeamento de Ações: A posição da célula escolhida no sub-tabuleiro força o próximo jogador a atuar no sub-tabuleiro equivalente daquele índice.
- Jogada Livre: Liberação para atuação em qualquer sub-tabuleiro aberto quando o destino obrigatório já estiver encerrado ou empatado.
- Condição de Vitória: Alinhamento de três sub-tabuleiros conquistados horizontalmente, verticalmente ou diagonalmente no grid global.

---

## Desenvolvimento e Implementações

- O jogo já está consolidado, contudo sua implementação resume-se numa percepção prática, de primeiro modo feito para enfrentar os paradigmas da lógica de programação. Ademais, prosseguir polindo e reduzindo redundância do código já feito e corrigir furos de lógica.