import React from "react";
import classes from "./styles.module.css";

const Kamar = (props) => {
const { namaKamar, kapasitas } = props;
return (
    <div className={classes.kamar}>
        <p>{`${namaKamar} (${kapasitas})`}</p>
    </div>
);
};
export default Kamar;