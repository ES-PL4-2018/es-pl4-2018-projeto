# SISTEMA DE NOMES PARA ARTEFACTOS / ENUMERAÇÃO DAS REVISÕES

**DOC ID:** QUA_NOMES_VERSOES

| UNIDADE | COORDENADOR |
|---------|-------------|
|    QUA     |    João Soares    |

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|---|---|---|---
|0.1 | 12/10/2018 | Sergii Mykolyshyn | Criação processo
|0.2 | 13/10/2018 | João Soares | Revisão
|1.0 | 13/10/2018 | João Soares | Aprovação
|2.0 | 20/10/2018 | Pedro Fernandes | Revisão, edição e aprovação

#### DESCRIÇÃO DO PROCESSO
Procedimento gestão de nomes a atribuir aos artefactos gerados no âmbito do processo. Por ex. nomear um relatório de tarefa/esforço, um processo ou uma ata. Este processo também é responsável por garantir a enumeração das revisões seguindo um padrão.

#### RESPONSÁVEIS
* Todos os elementos da equipa são responsáveis pelo processo.

#### INPUTS

* Informações necessárias à redação do relatório de tarefa/esforço, processo ou ata.

#### CRITÉRIO DE ATIVAÇÃO/TRIGGER

* Ativado sempre que é gerado algum artefacto.

#### DESCRIÇÃO DAS TAREFAS

* Nomeação de artefactos utilizando as seguintes regras:
  * Nomes de processos:
    * Os nomes dos processos devem seguir o seguinte modelo: EQUIPA_NOME_PROCESSO_ABREVIADO;
    * Como exemplo: QUA_NOMES_VERSOES, GES_RH_EQUIPA.
  * Nomes das atas:
    * Os nomes das atas devem seguir o seguinte modelo: ATA_EQUIPA_NUMEROREUNIAO_NUMEROSPRINT;
    * Sempre que se passa de sprint o numero das reuniões volta a 1;
    * Como exemplo: ATA_QUA_1_S2, ATA_REQ_3_S2, ATA_REQ_1_S3.
  * Nomes dos relatórios de esforço:
    * Os nomes dos relatórios de esforço devem seguir o seguinte exemplo: TAREFA_EQUIPA_NOMETAREFA;
    * Como exemplo: TAREFA_QUA_REVISAO_QUA_NOMES_VERSOES.
  * Restantes artefactos:
    * Os nomes dos restantes artefactos que aqui não se encontram descritos, deverão ter sempre no inicio a unidade e a tipologia a que se refere o documento, como por exemplo, QUA_REL_ACOMPANHAMENTO_GES, GES_REL_RISCOS;
      * Deve-se tentar sempre manter o nome curto, mas que seja perceptível o conteúdo do documento.

* Alteração de versão segundo as seguintes regras:
  * Todas as revisões/alterações refletem-se numa "décima" (0.2 para 0.3), aquando a validação/aprovação das alterações do documento, o mesmo passa para a versão 1.0, 2.0 e em diante.
  
* Tabela de Acrónimos

| Acrónimo | Descrição
| :---: | ---
|GES|Equipa Gestão
|REQ|Equipa Requisitos
|IMP|Equipa Implementação
|TST|Equipa Testes
|QUA|Equipa Qualidade
|ENV|Equipa Ambiente
|RH|Recursos Humanos
|RSC|Risco(s)
|REL|Relatório
|REV|Revisão

#### OUTPUTS

* Artefacto nomeado consoante a regras descritas.

#### CRITÉRIO DE SAÍDA

* O processo termina quando o artefacto estiver aprovado e validado.

#### MÉTRICAS DE AVALIAÇÃO

* Número de alterações de versão do artefacto.

#### APROVAÇÃO E VALIDAÇÃO

* A tarefa é revista por membros da equipa de QUA e posteriormente publicada no *GitHub*.