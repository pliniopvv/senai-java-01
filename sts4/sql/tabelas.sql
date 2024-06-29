CREATE TABLE Funcionario (
    id LONG PRIMARY KEY,
    matricula TEXT,
    tempo_Experiencia INT,
    endereco LONG
)

CREATE TABLE Endereco (
    id LONG PRIMARY KEY,
    logradouro TEXT,
    estado VARCHAR(2),
    cidade TEXT,
    numero TEXT,
    CEP TEXT
)

CREATE TABLE Nutricionista (
    id LONG PRIMARY KEY,
    CRN TEXT,
    especialidade TEXT
)

CREATE TABLE Paciente (
    id LONG PRIMARY KEY,
    nome TEXT,
    data DATE,
    CPF TEXT,
    telefone TEXT,
    email TEXT,
    endereco LONG
)

CREATE TABLE Consulta (
    id LONG PRIMARY KEY,
    nutricionista LONG,
    paciente LONG,
    data DATE,
    observacoes TEXT
)

ALTER TABLE Funcionario ADD CONSTRAINT fucionario_fk_endereco FOREIGN KEY (Endereco) REFERENCES Endereco(id);
ALTER TABLE Paciente ADD CONSTRAINT paciente_fk_endereco FOREIGN KEY (Endereco) REFERENCES Endereco(id);

ALTER TABLE Consulta ADD CONSTRAINT consulta_fk_Nutricionista FOREIGN KEY (Nutricionista) REFERENCES Nutricionista(id);
ALTER TABLE Consulta ADD CONSTRAINT consulta_fk_Paciente FOREIGN KEY (Paciente) REFERENCES Paciente(id);

-- Insira, pelo menos, três registros para cada tabela.

INSERT INTO Funcionario (id, matricula, tempo_Experiencia, endereco)
VALUES
    (1, '12345', 5, 1),
    (2, '67890', 3, 2),
    (3, '54321', 2, 3);

INSERT INTO Endereco (id, logradouro, estado, cidade, numero, CEP)
VALUES
    (1, 'Rua A', 'SP', 'São Paulo', '123', '01234-567'),
    (2, 'Avenida B', 'RJ', 'Rio de Janeiro', '456', '98765-432'),
    (3, 'Praça C', 'MG', 'Belo Horizonte', '789', '54321-098');

INSERT INTO Nutricionista (id, CRN, especialidade)
VALUES
    (1, '1234', 'Clínica'),
    (2, '5678', 'Esportiva'),
    (3, '9876', 'Pediatra');

INSERT INTO Paciente (id, nome, data, CPF, telefone, email, endereco)
VALUES
    (1, 'Maria Silva', '2000-01-15', '123.456.789-00', '(11) 98765-4321', 'maria@email.com', 1),
    (2, 'João Santos', '1995-05-20', '987.654.321-00', '(21) 98765-4321', 'joao@email.com', 2),
    (3, 'Ana Pereira', '1988-12-10', '654.321.987-00', '(31) 98765-4321', 'ana@email.com', 3);

-- Atualize o telefone de um dos nutricionistas.

UPDATE Nutricionista
SET telefone = '(11) 99999-9999'
WHERE id = 2;

-- Delete um registro da tabela.

DELETE FROM Paciente
WHERE id = 3;
