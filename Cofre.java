import java.util.Scanner;

class AulaHoje {
static Scanner entrada = new Scanner(System.in);
static String[] itens = new String[10];
static String senha = "1234";
static int quantidade = 0, erros = 0;
static boolean aberto = true, bloqueado = false;

public static void main(String[] args) {
int opcao = 0;
while (opcao != 6) {
System.out.println("\n1 Guardar  2 Trancar  3 Destrancar");
System.out.println("4 Ver itens  5 Retirar  6 Sair");
System.out.print("Escolha: ");
opcao = entrada.nextInt();
entrada.nextLine();

if (opcao == 1 && aberto) {
if (quantidade < itens.length) {
System.out.print("Nome do item: ");
itens[quantidade] = entrada.nextLine();
quantidade++;
} else System.out.println("Cofre cheio.");
} else if (opcao == 1) System.out.println("Cofre fechado.");
else if (opcao == 2 && aberto) aberto = false;
else if (opcao == 3) destrancar();
else if (opcao == 4 || opcao == 5) mostrarItens();

if (opcao == 5 && aberto && quantidade > 0) {
System.out.print("Número do item para retirar: ");
int n = entrada.nextInt() - 1;
entrada.nextLine();
if (n >= 0 && n < quantidade) {
for (int i = n; i < quantidade - 1; i++) itens[i] = itens[i + 1];
quantidade--;
} else System.out.println("Número inválido.");
}
}
}

static void destrancar() {
if (bloqueado) System.out.println("Cofre bloqueado.");
else if (aberto) System.out.println("Cofre já está aberto.");
else {
System.out.print("Senha: ");
if (entrada.nextLine().equals(senha)) {
aberto = true;
erros = 0;
} else if (++erros == 3) bloqueado = true;
else System.out.println("Senha incorreta. Erros: " + erros);
}
}

static void mostrarItens() {
if (!aberto) System.out.println("Cofre fechado.");
else if (quantidade == 0) System.out.println("Sem itens.");
else for (int i = 0; i < quantidade; i++)
System.out.println((i + 1) + " - " + itens[i]);
}
}