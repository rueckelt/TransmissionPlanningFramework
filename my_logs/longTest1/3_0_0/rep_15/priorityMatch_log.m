
% 2015-10-17 01:04:06

% my_logs\longTest1\3_0_0\rep_15\priorityMatch_log.m
scheduling_duration_us = 9791;

% schedule
schedule_f_t_n(:,:,1) = [6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 2; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [17; 8; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 1; 0; 9; 16; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 17; 17; 17; 17; 17; 17; 17; 17; 11; 11; 11; 11; 15; 17; 17; 17; 6; 0; 0];
schedule_f_t_n(:,:,5) = [0; 9; 16; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,6) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6; 6];
schedule_f_t_n(:,:,7) = [0; 0; 0; 17; 8; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,8) = [0; 0; 0; 0; 0; 1; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 11; 8; 0];

% cost function results
vioSt = [0, 0, 0, 340, 0, 0, 0, 0];
vioDl = [0, 0, 0, 0, 0, 60, 0, 0];
vioNon = [0, 0, 0, 0, 0, 5346, 0, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 4, 4, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [1400, 0, 0, 0, 0, 0, 0, 0];
vioLcy = [16500, 0, 0, 0, 0, 11550, 0, 0];
vioJit = [22000, 0, 0, 0, 0, 8250, 0, 0];
cost_vio = 677626;
cost_switches = 0;
cost_ch = 5490;
costTotal = 683116;

% priorityMatch
% 
% ############### Network 0 ##############
% F0	|[0]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[10]6	|6	|6	|6	|6	|6	|6	|6	|2	|	|[20]	|	|	|	|	|
% F1	|[0]17	|8	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|1	|	|9	|16	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|17	|17	|17	|17	|[10]17	|17	|17	|17	|11	|11	|11	|11	|15	|17	|[20]17	|17	|6	|	|	|
% F4	|[0]	|9	|16	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F5	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|6	|6	|6	|6	|6	|6	|[20]6	|6	|6	|6	|6	|
% F6	|[0]	|	|	|17	|8	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F7	|[0]	|	|	|	|	|1	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|11	|8	|	|
