import React from "react";
import classes from "./styles.module.css";

const Kamar = (props) => {
const { namaKamar, kapasitas } = props;
return (
    <div className={classes.kamar}>
        <h4 className={classes.atribut}>{`${namaKamar} (${kapasitas})`}</h4>
    </div>
);
};
export default Kamar;