CREATE TABLE items (
  id SERIAL PRIMARY KEY,
  name CHARACTER VARYING(70),
  cost NUMERIC(15,2),
  active BOOLEAN DEFAULT true
);