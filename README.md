# dictionary

Parte 1) A ser entregue em forma de código documentado. Peso 60%.

Desenvolva uma classe ChainHashMap de dicionário simples capaz de armazenar pares (chave, valor) e resolver conflitos através de encadeamento. Para simplificar a tarefa, você deve considerar que as chaves e os valores serão do tipo String.

Use o método hashCode padrão de Java para calcular o valor de hash de cada String chave. A sua classe deve ser responsável pela etapa de compressão.
Cada bucket do dicionário deve ser modelado como um Arraylist.
O seu dicionário deve prover métodos para contar o número de colisões e também retornar o fator de carga do dicionário a qualquer instante.
O método construtor recebe como argumento o número inicial de buckets.
Em caso de inserção de chaves repetidas, o dicionário deve apenas atualizar o valor associado à chave.
A sua classe deve obedecer à interface Map e estender classe abstrata AbstractMap. Ambos arquivos estão em anexo.

Parte 2) A ser entregue em forma de relatório sucinto. Peso 40%.
Considerando o dicionário construído na parte anterior:
Construa dois dicionários, um com 10000 buckets e outro com 100 buckets.
Em cada dicionário do item anterior, insira  um milhão de pares gerados aleatoriamente.
Responda as seguintes perguntas após ter feito o item 2:
 Qual tabela possui o menor fator de carga?
 Qual tabela apresenta menor tempo de busca para 100000 chaves aleatórias que podem estar ou não no dicionário?
