#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
//incluindo as bibliotecas

int main()
{

  /*Criando a struct  */
  struct ficha_de_aluno
  {
    char nome[40];
    float nota1,nota2,nota3,nota4, media;

  };

   /*Criando a variável aluno que será do
     tipo struct ficha_de_aluno       */
  struct ficha_de_aluno aluno[40], aux;
  //aux= variavel que auxilia na ordenação do registro aluno
  int i,k,q, opcao, t, j;
  //indices e primeira escolha
  char resposta, resposta2,resposta3,resposta4, pesquisa[40];
  //respostas dos whiles
  for(i=0;i<40;i++)
  {

                      aluno[i].nome[0]= '\0';
                       aluno[i].nota1=0;
                       aluno[i].nota2=0;
                       aluno[i].nota3=0;
                       aluno[i].nota4=0;
                       aluno[i].media=0;
  }
i=0;
q=0;
k=0;
//zerando as variaveis struct e indices
  do
  {

      printf("_________Sistema de gerenciamento de notas__________\n");
      printf("_______++++++++++ Menu de Tarefas ++++++++++________\n");
      printf("_____[1]------------ Cadastrar ------------[1]______\n");
      printf("_____[2]------------ Consultar ------------[2]______\n");
      printf("_____[3]------------- Excluir -------------[3]______\n");
     printf("---Qual tarefa deseja realizar? : ");
      scanf("%d", &opcao);
//procedimento de escolha da tarefa a ser realizada
      switch(opcao)
        {
         case 1:
//caso opção = 1 então


         do{
                printf("Nome do aluno ............: ");
                fflush(stdin);
                fgets(aluno[i].nome,40,stdin);
                printf("Informe a primeira nota ..: ");
                scanf("%f", &aluno[i].nota1);
                  while(aluno[i].nota1 <0 ||aluno[i].nota1>10)
                {
                printf("Digite uma nota de 0 a 10: ");
                scanf("%f", &aluno[i].nota1);
                }
                printf("Informe a segunda nota ...: ");
                scanf("%f", &aluno[i].nota2);
                while(aluno[i].nota2 <0 ||aluno[i].nota2>10)
                {
                printf("Digite uma nota de 0 a 10: ");
                scanf("%f", &aluno[i].nota2);
                }
                printf("Informe a terceira nota ..: ");
                scanf("%f", &aluno[i].nota3);
                 while(aluno[i].nota3 <0 ||aluno[i].nota3>10)
                {
                printf("Digite uma nota de 0 a 10: ");
                scanf("%f", &aluno[i].nota3);
                }
                printf("Informe a quarta nota ....: ");
                scanf("%f", &aluno[i].nota4);
                 while(aluno[i].nota4 <0 ||aluno[i].nota4>10)
                {
                printf("Digite uma nota de 0 a 10: ");
                scanf("%f", &aluno[i].nota4);
                }
                aluno[i].media = (aluno[i].nota1 + aluno[i].nota2 + aluno[i].nota3 + aluno[i].nota4)/4;
                printf("Deseja cadastrar outro aluno?\n[S/N]..: ");
               scanf("%s", &resposta);
                i= i+1;
                while(resposta != 's'&&resposta!='S'&&resposta!='n'&&resposta!='N')
                {
                printf("RESPONDA S de sim ou N de nao: ");
                scanf("%s", &resposta);
                }




                system("cls");
            }while(resposta=='s' ||resposta == 'S');

//solicitando os dados dos alunos até a condição de parada ser atendida


               break;

     case 2:
//se opção = 2 então
          printf("+=====Opcao escolhida = Consultar cadastros.=====+\n");
          printf("______________+=====Consulta =====+_______________\nSe nenhum aluno estiver cadastrado entao o sistema\nnao tem nenhum resultado para exibir.\n\n");
          for(k=0;k<40;k++)
          {
              if(aluno[k].nome[0]>'\0')
              {
                  printf("\n====Aluno....:\n");
                  printf("Nome ............: %s\n", aluno[k].nome);
                  printf("Primeira nota....: %.2f\n", aluno[k].nota1);
                  printf("Segunda nota ....: %.2f\n" , aluno[k].nota2);
                  printf("Terceira nota ...: %.2f\n" , aluno[k].nota3);
                  printf("Quarta nota .....: %.2f\n" , aluno[k].nota4);
                  printf("Media ...........: %.2f\n\n" , aluno[k].media);
              }



              }
         break;
//quando a variavel nome do registro de indice 'i' não for nula então o sistema mostrará o registro na tela
      case 3:
//caso opção = 3 entao
          printf("+=====Tarefa escolhida = Excluir cadastros.=====+\n");
          printf("_____________+=====Exclusao.=====+______________\n");
          printf("Digite o nome de um aluno cadastrado para exclusao: ");
          fflush(stdin);
          fgets(pesquisa,40,stdin);

          for(q=0;q<40;q++)
          {
              if(strcmp(aluno[q].nome,pesquisa)==0)
              {
                  printf("Primeira nota....: %.2f\n", aluno[q].nota1);
                  printf("Segunda nota ....: %.2f\n" , aluno[q].nota2);
                  printf("Terceira nota ...: %.2f\n" , aluno[q].nota3);
                  printf("Quarta nota .....: %.2f\n" , aluno[q].nota4);
                  printf("Media ...........: %.2f\n" , aluno[q].media);
                  printf("Esses sao os dados do(a) %s deseja excluir mesmo assim?\n[S/N]..: ",pesquisa );

                  scanf("%s", &resposta3);
                   while(resposta3 != 's'&&resposta3!='S'&&resposta3!='n'&&resposta3!='N')
                {
                printf("RESPONDA S de sim ou N de nao: ");
                scanf("%s", &resposta3);
                }


                  if (resposta3 == 's' ||resposta3=='S')
                  {
                       aluno[q].nome[0]= '\0';
                       aluno[q].nota1=0;
                       aluno[q].nota2=0;
                       aluno[q].nota3=0;
                       aluno[q].nota4=0;
                       aluno[q].media=0;
                       printf("O(A) %s foi excluido(a) do sistema\n\n ", pesquisa);
                  }
                  else {printf("O(A) %s nao foi excluido(a) do sistema\n ", aluno[q].nome);}

              }


          }
          printf("-Se o nome procurado ainda nao foi cadastrado\nou foi excluido, o sistema nao realizara a tarefa proposta--.\n\n");
//dentro da estrutura "para" se o valor da pesquisa for igual a variavel nome no registro aluno de indice 'i'entao as informações do aluno serão confirmadas
//e depois caso a resposta seja sim o registro de indice 'i' será anulado.
      break;
      default:
          //caso a opção seja diferente de 1 e 2 e 3 então ...
      printf("Opcao invalida\n\n");
        }
      printf("Deseja fazer alguma(mais alguma) tarefa?\n[S/N]..: ");

      scanf("%s",&resposta4);
      //se resposta = s então o sistema irá pedir outra opção de tarefa.senão o programa acaba
      while(resposta4 != 's'&&resposta4!='S'&&resposta4!='n'&&resposta4!='N')
                {
                printf("RESPONDA S de sim ou N de nao: ");
                scanf("%s", &resposta4);
                }
                for(t=0;t<40;t++)
                {
                    for(j=t+1;j<39;j++)
                    {
                        if(aluno[t].nome>aluno[j].nome)
                        {
                            aux= aluno[t];
                            aluno[t]= aluno[j];
                            aluno[j]= aux;


                        }
                    }
                }
//ordenando o vetor de registros em ordem alfabética
    system("cls");
    }while(resposta4 == 's' || resposta4 == 'S');

      system("pause");
      //pausando o sistema
      return(0);
    }

