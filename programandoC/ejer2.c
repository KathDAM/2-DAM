#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>

int main(void){ 
   
    __pid_t p1,p2;

    p1 = fork();

    if(p1 == 0){
        printf("La rama 1 -%d\n", getpid());
        printf("La rama 1.1 -%d\n", getpid());
          
    }else{
        p2 = fork();
        printf("La rama 2 -%d\n", getpid());
        printf("La rama 2.2 -%d\n", getpid()); 
    }

    return 0;
}