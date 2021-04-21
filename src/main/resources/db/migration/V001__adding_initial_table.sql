CREATE TABLE patients(
  id UUID PRIMARY KEY,
  name CHARACTER VARYING(100) NOT NULL,
  address CHARACTER VARYING (500) NOT NULL,
  email_id CHARACTER VARYING(100) NOT NULL UNIQUE,
  phone_number CHARACTER VARYING(15) NOT NULL UNIQUE,
  password CHARACTER VARYING(15) NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE appointments(
  id UUID PRIMARY KEY,
  patient_id UUID NOT NULL,
  time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  completed BOOLEAN NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT appointments_fkey_patients FOREIGN KEY (patient_id)
        REFERENCES patients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION  
);

