#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

int main(void){ 
   
    __pid_t p1,p2,p3;

    p1 = fork();

    if(p1 == 0){
        printf("La rama 1 -%d\n", getpid());

    }else{
        p2 = fork();

        if(p2 == 0){
            printf("La rama 2 -%d\n", getpid());

        }else{
            p3 = fork();
             
            if(p3 == 0){
                printf("La rama 3 -%d\n", getpid());
            }
        }
    }

    return 0;
}

/*#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid;
    int i;

    // Crear 3 procesos hijos
    for (i = 0; i < 3; i++) {
        pid = fork();

        if (pid == 0) {
            // Cada proceso hijo entra aquí
            printf("Soy el proceso hijo P%d con PID: %d y el PID de mi padre es: %d\n", i + 1, getpid(), getppid());
            break;  // Cada hijo sale del bucle después de crearse
        }
    }

    return 0;
}
*/