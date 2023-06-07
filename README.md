# Desafio 01 de Java
> **Nota**
> Veja o final do README para notas de atualização

Nesse desafio o usuário digita um número qualquer tentando advinhar qual o computador irá escolher aleatoriamente.

Ele possui 4 níveis:

- **Easy** O mais fácil dos modos. Só dez (10) opções para descobrir o que o computador pode escolher.
- **Medium** O padrão dos modos. Apenas 100 (100) opções para descobrir o que o computador pode escolher.
- **Hard**  O mais difícil sem muitos esxageros. São mil (1.000) opções para descobrir o que o computador pode escolher.
- **Joy has no mercy** O mais difícil de todos os modos, feito para fazer até a sua mãe chorar. São dez mil (10.000) opções para descobrir o que o computador pode escolher.

A cada jogada o usuário pode ganhar:
- **10 (dez)** pontos se acertar em cheio;
- **5 (cinco)** pontos se chegar pertinho; e
- **0 (zero)** pontos se você for a *vergonha da profisson!*

O sistema também guarda o seu histórico de jogadas, pontuação e o que o computador respondeu.

## Atualizações
Última atualização 07/06/23 @ 10:15
- O cáculo da dificuldade estava rodando de forma errada. Apesar de funcionar como deveria, o valor era dinâmico e não fixo.
- Os valores das jogadas realizadas agora são exibidas em uma tabela.
- Agora ao invés de perguntar a cada jogada se o usuário deseja sair, o jogo exibe a mensagem a cada 5 partidas
- Foi implementado recursos de cor para diferenciar a mensagem para continuar ou não o jogo.
- Pequenas implementações na diagramação do textos foram feitas.
- Agora o sistema permite escolher os caracteres **S** (SIM) ou **N** (NÃO) para permitir que o usuário interrompa a jogatina.