// BancoAspect.aj
public aspect BancoAspect {
    pointcut realizarSaquePointcut(double valor) :
        execution(* ContaBancaria.realizarSaque(double)) && args(valor);

    before(double valor) : realizarSaquePointcut(valor) {
        System.out.println("Verificando saldo antes do saque na conta " + ((ContaBancaria) thisJoinPoint.getTarget()).getTipoConta());
        ContaBancaria conta = (ContaBancaria) thisJoinPoint.getTarget();
        if (!conta.saldoSuficiente(valor)) {
            System.out.println("Saldo insuficiente na conta " + conta.getTipoConta());
            throw new SaldoInsuficienteException("Saldo insuficiente na conta " + conta.getTipoConta());
        }
    }
}
