#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>

/*int main(void){
    int num =  5;
    __pid_t hijo;

    hijo = fork();

    if(num == 0){
        num = 25;
        printf("Mi padre es %d\n", getpid());
    }

    printf("Aqui te muestro el numero %d y mi PID es %d\n", num, getpid());

    return 0;
}*/

int main(void){
    int num =  5;
    __pid_t hijo;

    hijo = fork();

    if(num > 0){
        num = 25;
        printf("Mi padre es %d\n", getpid());
    }

    printf("Aqui te muestro el numero %d y mi PID es %d\n", num, getppid());
    printf("Aqui te muestro el numero %d y mi PID es %d\n", num, getpid());
  
    return 0;
}