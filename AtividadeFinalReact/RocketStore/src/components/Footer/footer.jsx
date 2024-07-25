import React from 'react';
import styles from './style.module.css';

const Footer = () => {
    return (
        <footer>
            <div id={styles.footer_content}>
                <div id={styles.footer_contacts}>
                    <h1>Logo</h1>
                    <p>It's all about your dream.</p>
                    <div id={styles.footer_social_media}>
                        <a href="https://www.instagram.com/" className={styles.footer_link} id={styles.instagram}>
                            <i className="fa-brands fa-instagram"></i>
                        </a>
                        <a href="https://facebook.com" className={styles.footer_link} id={styles.facebook}>
                            <i className="fa-brands fa-facebook-f"></i>
                        </a>
                        <a href="https://web.whatsapp.com/" className={styles.footer_link} id={styles.whatsapp}>
                            <i className="fa-brands fa-whatsapp"></i>
                        </a>
                    </div>
                </div>
                <ul className={styles.footer_list}>
                    <li>
                        <h3>Blog</h3>
                    </li>
                    <li>
                        <p className={styles.footer_link}>tech</p>
                    </li>
                    <li>
                        <p className={styles.footer_link}>Music</p>
                    </li>
                    <li>
                        <p className={styles.footer_link}>Adventures</p>
                    </li>
                </ul>
                <ul className={styles.footer_list}>
                    <li>
                        <h3>Products</h3>
                    </li>
                    <li>
                        <p className={styles.footer_link}>App</p>
                    </li>
                    <li>
                        <p className={styles.footer_link}>Desktop</p>
                    </li>
                    <li>
                        <p className={styles.footer_link}>Sound</p>
                    </li>
                </ul>
                <div id={styles.footer_subscribe}>
                    <h3>Subscribe</h3>
                    <p>Enter your e-mail to get notified about our news solutions</p>
                    <div id={styles.input_group}>
                        <input type="email" id={styles.email} />
                        <button>
                            <i className="fa-regular fa-envelope"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div id={styles.footer_copyright}>
                &copy; 2024 todos os direitos reservados a KaKuNa PokeCompany
            </div>
        </footer>
    );
};

export default Footer;
